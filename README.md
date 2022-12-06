# 책임 연쇄 패턴

한번에 처리할 일을 객체를 나누어 여러 단계로 처리하는 패턴.

client 입장에서 처리 과정을 한 눈에 볼 수 있음.

연쇄적인 과정을 객체간의 소통을 통해 해결함으로 좀 더 객체지향적이라 할 수 있음.

매번 입출력 인스턴스를 반환하면서 진행하기 때문에 성능이 중요한 경우 안 쓰는게 좋음.


# 기존 연쇄 패턴

```java
public class Main {
    public static void main(String[] args) {
        Support alice = new NoSupport("Alice");
        Support bob = new LimitSupport("Bob", 100);
        Support charlie = new SpecialSupport("Charlie", 429);
        Support diana = new LimitSupport("Diana", 200);
        Support elmo = new OddSupport("Elmo");

        alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo);

        // 다양한 문제 발생
        for (int i = 0; i < 500; i += 33) {
            alice.support(new Trouble(i));
        }
    }
}
```


# 파이프를 활용한 연쇄 패턴 (기존 연쇄 패턴의 개선된 버전)

```java
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
```

# 용도에 따라 메서드가 분리된 파이프 패턴

// TODO 진행중