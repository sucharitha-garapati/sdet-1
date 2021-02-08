fruit_list = {
    "apple": 10,
    "banana": 15,
    "orange": 8,
    "peaches": 15
}

availability = input("What are you looking for? ").lower()

if(availability in fruit_list):
    print("Yes, this is available")
else:
    print("No, this is not available")