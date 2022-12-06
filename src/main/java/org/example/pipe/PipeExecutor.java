package org.example.pipe;

import org.example.pipe.handler.Handler;

public class PipeExecutor {

    public static void main(String[] args) {
        String result = new Pipeline<>((Handler<Pair, Integer>) input -> input.a + input.b)
                .addHandler(input -> input * 2)
                .addHandler(Object::toString)
                .execute(new Pair(1, 3));
        System.out.println(result);
    }

    static class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}