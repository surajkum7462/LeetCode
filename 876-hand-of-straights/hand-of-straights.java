class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // If total cards aren't divisible by groupSize, grouping is impossible
        if (hand.length % groupSize != 0) {
            return false;
        }

        // Count the frequency of each card
        TreeMap<Integer, Integer> cardCount = new TreeMap<>();
        for (int card : hand) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }

        // Try to create groups
        for (int card : cardCount.keySet()) {
            int count = cardCount.get(card);
            if (count > 0) {
                // Attempt to form a group starting with this card
                for (int i = 0; i < groupSize; i++) {
                    int currentCard = card + i;
                    if (cardCount.getOrDefault(currentCard, 0) < count) {
                        return false;
                    }
                    // Decrease the count for this card
                    cardCount.put(currentCard, cardCount.get(currentCard) - count);
                }
            }
        }

        return true;
        
    }
}