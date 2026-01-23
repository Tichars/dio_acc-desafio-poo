package br.com.dio_acc.dominio.repositorio;

import br.com.dio_acc.dominio.Dev;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public final class DevRepo {

    private final Map<Long, Dev> storage = new ConcurrentHashMap<>();

    public Dev save(Dev dev) {
        storage.put(dev.id(), dev);
        return dev;
    }
    public Optional<Dev> findById(long id) {
        return Optional
                .ofNullable(storage.get(id));
    }
    public List<Dev> findAll() {
        return  List.copyOf(storage.values());
    }
    public boolean deleteById(long id) {

        return storage.remove(id)!= null;
    }
}
