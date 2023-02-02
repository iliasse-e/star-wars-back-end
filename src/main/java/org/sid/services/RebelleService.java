package org.sid.services;

import org.sid.entities.Rebelle;
import org.sid.exceptions.RebelleNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RebelleService {
    Rebelle saveRebelle(Rebelle rebelle);

    List<Rebelle> listRebelle();

    Rebelle getRebelle(Long rebelleId) throws RebelleNotFoundException;

    boolean deleteRebelle(long rebelleId) throws RebelleNotFoundException;

    @Transactional
    Rebelle stopRebelleFormation(Long rebelleId)  throws RebelleNotFoundException;
}
