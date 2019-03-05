package com.example.solitaire

class TableauPile(var cards: MutableList<Card> = mutableListOf()) {
    init {
        if (cards.size > 0) {
            cards.last().faceUp = true
        }
    }

    fun addCards(newCards: MutableList<Card>): Boolean {
        if (cards.size > 0) {
            if (newCards.first().value == cards.last().value - 1 && suitCheck(newCards.first(), cards.last())) {
                cards.addAll(newCards)
                return true
                }
            }else if(newCards.first().value == 12) {
            cards.addAll(newCards)
            return true
        }
        return false
    }

    fun removeCards(tappedIndex: Int){
        for ( i in tappedIndex..cards.lastIndex){
            cards.removeAt(tappedIndex)
        }

        if(cards.size > 0){
            cards.last().faceUp = true
        }
    }

    private fun suitCheck(c1: Card, c2: Card): Boolean {
        if ((redSuits.contains(c1.suite) && blackSuits.contains(c2.suite)) ||
            (blackSuits.contains(c1.suite) && redSuits.contains(c2.suite))
        ) {
            return true
        }
        return false
    }
}

