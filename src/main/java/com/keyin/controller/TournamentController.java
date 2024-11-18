package com.keyin.controller;

import com.keyin.model.Tournament;
import com.keyin.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {

    @Autowired
    private TournamentRepository tournamentRepository;

    @GetMapping
    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Tournament getTournamentById(@PathVariable Long id) {
        return tournamentRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Tournament createTournament(@RequestBody Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    @PutMapping("/{id}")
    public Tournament updateTournament(@PathVariable Long id, @RequestBody Tournament tournamentDetails) {
        Tournament tournament = tournamentRepository.findById(id).orElse(null);
        if (tournament != null) {
            tournament.setStartDate(tournamentDetails.getStartDate());
            tournament.setEndDate(tournamentDetails.getEndDate());
            tournament.setLocation(tournamentDetails.getLocation());
            tournament.setEntryFee(tournamentDetails.getEntryFee());
            tournament.setCashPrize(tournamentDetails.getCashPrize());
            tournament.setParticipants(tournamentDetails.getParticipants());
            return tournamentRepository.save(tournament);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTournament(@PathVariable Long id) {
        tournamentRepository.deleteById(id);
    }
}
