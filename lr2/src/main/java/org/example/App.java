package org.example;

public class App {
    public static void main(String[] args) {
        try {
            Hotel hotel1 = new Hotel(null, "Минск", 5, 1, 0);
            Hotel hotel2 = new Hotel("Уют", "Гомель", 3, 50, 0);

            System.out.println("Тест 1: Успешное бронирование");
            hotel1.bookRoom();


            System.out.println("\nТест 2: Нет свободных комнат");
            hotel2.bookRoom();

        } catch (InvalidHotelDataTypeException e) {
            System.err.println("Ошибка в данных отеля: " + e.getMessage());
        } catch (HotelNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (RoomNotAvailableException e) {
            System.out.println("Ошибка бронирования: " + e.getMessage());
        }

        System.out.println("\nТест 3: Создание отеля с неверными данными (6 звезд)");
        try {
            Hotel badHotel = new Hotel("Плохой отель", "Москва", 6, 10, 5);
        } catch (InvalidHotelDataTypeException e) {
            System.out.println("Перехвачено исключение: " + e.getMessage());
        }

        System.out.println("\nТест 4: Выселение без бронирования");
        try {
            Hotel hotel3 = new Hotel("Пустой", "Брест", 2, 20, 20);
            hotel3.checkOut();
        } catch (InvalidHotelDataTypeException | RoomNotAvailableException e) {
            System.out.println("Перехвачено исключение: " + e.getMessage());
        }
    }
}