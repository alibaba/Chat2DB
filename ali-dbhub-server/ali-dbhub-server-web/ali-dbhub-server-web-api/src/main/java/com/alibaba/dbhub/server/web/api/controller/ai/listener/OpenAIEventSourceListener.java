package com.alibaba.dbhub.server.web.api.controller.ai.listener;

import java.util.Objects;

import com.alibaba.dbhub.server.web.api.controller.ai.response.ChatCompletionResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unfbx.chatgpt.entity.chat.Message;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * 描述：OpenAIEventSourceListener
 *
 * @author https:www.unfbx.com
 * @date 2023-02-22
 */
@Slf4j
public class OpenAIEventSourceListener extends EventSourceListener {

    private SseEmitter sseEmitter;

    public OpenAIEventSourceListener(SseEmitter sseEmitter) {
        this.sseEmitter = sseEmitter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onOpen(EventSource eventSource, Response response) {
        log.info("OpenAI建立sse连接...");
    }

    /**
     * {@inheritDoc}
     */
    @SneakyThrows
    @Override
    public void onEvent(EventSource eventSource, String id, String type, String data) {
        log.info("OpenAI返回数据：{}", data);
        if (data.equals("[DONE]")) {
            log.info("OpenAI返回数据结束了");
            sseEmitter.send(SseEmitter.event()
                .id("[DONE]")
                .data("[DONE]")
                .reconnectTime(3000));
            sseEmitter.complete();
            return;
        }
        ObjectMapper mapper = new ObjectMapper();
        ChatCompletionResponse completionResponse = mapper.readValue(data, ChatCompletionResponse.class); // 读取Json
        String text = completionResponse.getChoices().get(0).getDelta() == null
            ? completionResponse.getChoices().get(0).getText()
            : completionResponse.getChoices().get(0).getDelta().getContent();
        Message message = new Message();
        if (text != null) {
            message.setContent(text);
            sseEmitter.send(SseEmitter.event()
                .id(completionResponse.getId())
                .data(message)
                .reconnectTime(3000));
        }
    }

    @Override
    public void onClosed(EventSource eventSource) {
        sseEmitter.complete();
        log.info("OpenAI关闭sse连接...");
    }

    @SneakyThrows
    @Override
    public void onFailure(EventSource eventSource, Throwable t, Response response) {
        if (Objects.isNull(response)) {
            return;
        }
        ResponseBody body = response.body();
        String bodyString = null;
        if (Objects.nonNull(body)) {
            bodyString = body.string();
            log.error("OpenAI  sse连接异常data：{}，异常：{}", bodyString, t);
        } else {
            log.error("OpenAI  sse连接异常data：{}，异常：{}", response, t);
        }
        eventSource.cancel();
        Message message = new Message();
        message.setContent("出现异常,请检查是否网络能访问chatgpt或者在左下角的设置里面修改OpenAI Api Key：" + bodyString);
        sseEmitter.send(SseEmitter.event()
            .id("[ERROR]")
            .data(message));
        sseEmitter.send(SseEmitter.event()
            .id("[DONE]")
            .data("[DONE]"));
        sseEmitter.complete();
    }
}
