package org.example;


public class Hotel {
    private String name;
    private String city;
    private int stars;
    private int rooms;
    private int availableRooms;

    public Hotel(String name, String city, int stars, int rooms, int availableRooms) throws InvalidHotelDataTypeException {
        setName(name);
        setAvailableRooms(availableRooms);
        setRooms(rooms);
        setStars(stars);
        this.city=city;
    }

    public void bookRoom() throws HotelNotFoundException, RoomNotAvailableException {
        if (this.name == null || this.name.isEmpty()) {
            throw new HotelNotFoundException("Отель не найден");
        }
        if (availableRooms <= 0) {
            throw new RoomNotAvailableException("Нет доступных комнат для бронирования");
        }
        availableRooms--;
        System.out.println("Комната успешно забронирована в отеле " + name);
    }

    public void checkOut() throws RoomNotAvailableException {
        if (availableRooms >= rooms) {
            throw new RoomNotAvailableException("Все комнаты уже свободны, выселение невозможно");
        }
        availableRooms++;
        System.out.println("Выселение из отеля " + name + " прошло успешно");
    }

    public String getName() { return name; }
    public int getAvailableRooms() { return availableRooms; }
    public void setName(String name) throws InvalidHotelDataTypeException{
        if(name ==null){
            throw new InvalidHotelDataTypeException("Название отеля не может быть пустым");
        }
    }
    public void setStars(int Stars) throws InvalidHotelDataTypeException{
        if(Stars<1||Stars>5){
            throw new InvalidHotelDataTypeException("Количество звёзд может быть только от 1 до 5");
        }
    }
    public void setRooms(int Rooms) throws InvalidHotelDataTypeException{
        if(Rooms<0){
            throw new InvalidHotelDataTypeException("Комнат не может быть меньше нуля");
        }
    }
    public void setAvailableRooms(int ValueOfAvailiableRooms) throws InvalidHotelDataTypeException{
        if(ValueOfAvailiableRooms < 0|| ValueOfAvailiableRooms<rooms){
            throw new InvalidHotelDataTypeException("Доступных комнат не может быть меньше 0 или не может быть больше количества комнат");
        }
    }
}