package org.example.pipe.handler;

public class DeleteNumberHandler implements Handler<String, String> {
    @Override
    public String process(String input) {
        return input.replaceAll("\\d+", "");
    }
}
