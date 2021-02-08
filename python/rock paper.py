person1 = input("What is Player 1's name? ")
person2 = input("What is Player 2's name? ")

person1_choice = input(person1 + ", do you want to choose rock, paper or scissors? ").lower()
person2_choice = input(person2 + ", do you want to choose rock, paper or scissors? ").lower()

if person1_choice == person2_choice:
    print("It's a tie!")
elif person1_choice == 'rock':
    if person2_choice == 'scissors':
        print("Rock wins!")
    else:
        print("Paper wins!")
elif person1_choice == 'scissors':
    if person2_choice == 'paper':
        print("Scissors win!")
    else:
        print("Rock wins!")
elif person1_choice == 'paper':
    if person2_choice == 'rock':
        print("Paper wins!")
    else:
        print("Scissors win!")
else:
    print("Invalid input! You have not entered rock, paper or scissors, try again.")