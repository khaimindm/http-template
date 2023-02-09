package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Pokemon;

public class SimplePokemonFightingClubService implements PokemonFightingClubService {
    Pokemon pokemonWinner;

    @Override
    public Pokemon doBattle(Pokemon p1, Pokemon p2) {
        doDamage(p1, p2);
        if(p2.getHp() <= 0) {
            pokemonWinner = p1;                  
        } else if(p1.getHp() <= 0 && p2.getHp() >= 0) {
            pokemonWinner = p2;
        } else {
            doBattle(p2, p1);
        }
        
        return pokemonWinner;
    }

    @Override
    public void showWinner(Pokemon winner) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void doDamage(Pokemon from, Pokemon to) {
        int damage = from.getAttack() - (from.getAttack() * to.getDefense() / 100);
        from.setHp((short) (from.getHp() - damage));
        to.setHp((short) (to.getHp() - damage));         
    }
}
