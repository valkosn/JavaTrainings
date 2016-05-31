package com.javarush.test.level23.lesson02.task03;

/* Запретите создание экземпляров класса
Запретите создание экземпляров класса Listener.
*/
//TODO:done
class Solution {

    private static class Listener {
        public void onMouseDown(int x, int y) {
            //do something on mouse down event
        }

        public void onMouseUp(int x, int y) {
            //do something on mouse up event
        }
    }
}
