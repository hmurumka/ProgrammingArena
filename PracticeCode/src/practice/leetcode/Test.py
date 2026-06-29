def findCharacterCount(s, ch) :
    count = 0
    for letter in s :
        if(letter == ch) :
            count = count + 1
    return count



print(findCharacterCount('HarshMurumkar','u'))