class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxWords = 0;
        for(int i=0; i<sentences.length; i++){
            int wordCount = sentences[i].split(" ").length;
            if(wordCount > maxWords){
                maxWords = wordCount;
            }
        }
        return maxWords;
    }
}