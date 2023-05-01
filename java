
        class FoodItem
        {
            constructor(name, calories)
            {
                this.name = name;
                this.calories = parseInt(calories);
            }
        }

        let totalCalories = 0;
        let foodItems = [];

        let foodItemsData =
            [
                new FoodItem('donut', 200),
                new FoodItem('coke', 185),
                new FoodItem('hamburger', 355),
                new FoodItem('pizza', 285),
                new FoodItem('banana', 105),
                new FoodItem('hot dog', 150)
            ];

        function addFoodEvent(event)
        {
            event.preventDefault();
            const foodNameInput = document.getElementById("food-name");
            const caloriesInput = document.getElementById("calories");

            const foodName = foodNameInput.value;
            let calories = caloriesInput.value;

            if (!calories)
            {
                const foodItem = foodItemsData.find(item => item.name === foodName);

                if (foodItem)
                {
                    calories = foodItem.calories;
                }
                else
                {
                    alert('Calories not provided and no matching food item found.');
                    return;
                }
            }

            const newFood = new FoodItem(foodName, calories);
            foodItems.push(newFood);

            totalCalories += newFood.calories;
            const totalCaloriesSpan = document.getElementById("total-calories");
            totalCaloriesSpan.textContent = totalCalories;

            console.log(foodItems);
            console.log(`Total Calories: ${totalCalories}`);
