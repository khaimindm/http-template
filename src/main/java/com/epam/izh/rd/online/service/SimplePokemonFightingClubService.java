package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Pokemon;

public class SimplePokemonFightingClubService implements PokemonFightingClubService {
    //Pokemon pokemonWinner;

    @Override
    public Pokemon doBattle(Pokemon p1, Pokemon p2) {
        //SimplePokemonFightingClubService simplePokemonFightingClubService = new SimplePokemonFightingClubService();        
        /*if(p1.getHp() <= 0) {
            pokemonWinner = p2;
        } else if (p2.getHp() <= 0) {
            pokemonWinner = p1;
        } else {
            
        }*/
        
        System.out.println("hp защищающегося покемона: " + p2.getHp());
        System.out.println("hp аттакующего покемона: " + p1.getHp());

        
        doDamage(p1, p2);
        if(p2.getHp() <= 0) {
            return p1;
        } else if(p1.getHp() <= 0) {
            return p2;
        } else {
            doBattle(p2, p1);
        }
        
        return null;
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
