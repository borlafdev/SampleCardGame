package com.astraliss.samplecardgame;

import java.lang.reflect.Array;
import java.util.Random;


public class CardDeck
{
    int[] cards;
    int number;
	public CardDeck( int number)
	{
		cards  = new int[number];
		this.number = number;
        shuffle();
		String hola = "";
	}

    public void shuffle() {
        
        int contador = 0;
        while (contador < number -1) 
        {
            Random rnd = new Random();
            int num = rnd.nextInt(12);
            if (!alreadyIn(num))
            {
                cards[contador] = num;
                contador++;
            }
           
        }
        int num2;
        num2 = 5;
        num2 = num2 * 5;


    }
    public boolean alreadyIn(int num){
		for (int i = 0; i < cards.length; i++) {
			if(cards[i] == num)
				return true;
		}
		return false;

    }
    public int getCard(int pos) {
    	if(pos < 12)
    		return cards[pos];
    	else
    		return 1;
    }
    public void extract(int pos) {
        cards[pos] = 0;
    }

    public void empty()
    {
        for (int i = 0; i < number; i++)
        {
            cards[i] = 0;
        }
    }

    public boolean isEmpty() {
        for (int i = 0; i < number; i++)
        {
            if (cards[i] != 0)
                return false;
        }
        return true;
    }

 
}
