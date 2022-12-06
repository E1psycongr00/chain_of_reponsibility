package org.example.pipe.handler;

public class UpperCaseHandler implements Handler<String, String> {
    @Override
    public String process(String input) {
        return input.toUpperCase();
    }
}
