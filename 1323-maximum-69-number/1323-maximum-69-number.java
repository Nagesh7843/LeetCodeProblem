class Solution {
    public int maximum69Number (int num) {
        char[] narray = String.valueOf(num).toCharArray();

        for(int i = 0; i < narray.length; i++){
            if(narray[i] == '6'){
                narray[i] = '9';
                break;
            }
        }

        return Integer.parseInt(new String(narray));

    }
}