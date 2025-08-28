package sk.navratil.service;

import org.springframework.stereotype.Service;
import sk.navratil.entity.Room;
import sk.navratil.repository.RoomRepository;

@Service
public class RoomService {

    private RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room save(String name) {
        Room room = new Room();
        room.setName(name);
        return roomRepository.save(room);
    }
}
