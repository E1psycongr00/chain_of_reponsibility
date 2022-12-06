package org.example.pipe.handler;

public class ReplaceHandler implements Handler<String , String> {
    @Override
    public String process(String input) {
        return input.replaceAll("X", "O");
    }
}
