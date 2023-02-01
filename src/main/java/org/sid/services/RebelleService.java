package org.sid.services;

import org.sid.entities.Rebelle;
import org.sid.exceptions.RebelleNotFoundException;

import java.util.List;

public interface RebelleService {
    Rebelle saveRebelle(Rebelle rebelle);

    List<Rebelle> listRebelle();

    Rebelle getRebelle(Long rebelleId) throws RebelleNotFoundException;

    boolean deleteRebelle(long rebelleId) throws RebelleNotFoundException;
}
