package com.czx.pattern.strategy;

public class Client {
    public static void main(String[] args) {
        Player player = new Player();
        player.buy(5000D);
        System.out.println("�����Ҫ��Ǯ��" + player.calLastAmount());
        player.buy(12000D);
        System.out.println("�����Ҫ��Ǯ��" + player.calLastAmount());
        player.buy(12000D);
        System.out.println("�����Ҫ��Ǯ��" + player.calLastAmount());
        player.buy(12000D);
        System.out.println("�����Ҫ��Ǯ��" + player.calLastAmount());
    }
}
