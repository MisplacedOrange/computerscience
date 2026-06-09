let items =
[
    {name:"Big Mac", price:1.20, image:"img/1.png"},
    {name:"Vanilla Cone", price:2.00, image:"img/2.png"},
    {name:"Toasted Cookie", price:1.69, image:"img/3.png"},
    {name:"Sprinkle Cookie", price:1.69, image:"img/4.png"},
    {name:"Sausage McMuffin", price:3.10, image:"img/5.png"},
    {name:"McChicken", price:6.59, image:"img/6.png"},
    {name:"Junior Chicken", price:3.29, image:"img/7.png"},
    {name:"Large Fries", price:5.49, image:"img/8.png"},
    {name:"Small Fries", price:2.79, image:"img/9.png"},
    {name:"Apple Pie", price:1.69, image:"img/10.png"},
    {name:"Filet-O-Fish", price:3.20, image:"img/11.png"},
    {name:"Poutine", price:5.89, image:"img/12.png"},
    {name:"Cheeseburger", price:2.49, image:"img/13.png"},
    {name:"Quarter Pounder with Cheese", price:8.59, image:"img/14.png"},
    {name:"Hash Brown", price:1.69, image:"img/15.png"},
    {name:"Blueberry Muffin", price:1.69, image:"img/16.png"},
    {name:"Oreo McFlurry", price:2.89, image:"img/17.png"},
    {name:"Crispy Chicken Wrap", price:2.89, image:"img/18.png"},
    {name:"4 Chicken Nuggets", price:4.29, image:"img/19.png"},
    {name:"Small Salted Caramel Latte", price:3.19, image:"img/20.png"}
];

let maxRounds = 3;
let rulerWidth = 700;
let selectedItems = [];
let currentRound = 0;
let currentItem = null;
let totalDifference = 0;
let scaleMax = 5.00;
let guessedThisRound = false;
let gameOver = false;
let jokerX = 0;
let jokerY = 0;
let jokerRotate = 0;

resetGame();

function resetGame()
{
    currentRound = 0;
    totalDifference = 0;
    guessedThisRound = false;
    gameOver = false;
    scaleMax = getScaleValue();
    selectedItems = getThreeItems();

    resetJoker();
    buildRuler();
    setButtons(false);
    loadItem();

    document.getElementById("status").innerHTML =
        "New game started. Guess the first item.";
}

function applyScaleChange()
{
    resetGame();
}

function getScaleValue()
{
    let value = parseFloat(document.getElementById("scaleMax").value);

    if(isNaN(value))
    {
        value = 5;
    }
    if(value < 5)
    {
        value = 5;
    }
    if(value > 10)
    {
        value = 10;
    }

    value = Math.round(value * 2) / 2;
    document.getElementById("scaleMax").value = value.toFixed(2);
    return value;
}

function getThreeItems()
{
    let chosen = [];

    while(chosen.length < maxRounds)
    {
        let randomIndex = Math.floor(Math.random() * items.length);
        let alreadyUsed = false;
        let i = 0;

        for(i = 0; i < chosen.length; i++)
        {
            if(chosen[i] === items[randomIndex])
            {
                alreadyUsed = true;
            }
        }

        if(!alreadyUsed)
        {
            chosen[chosen.length] = items[randomIndex];
        }
    }

    return chosen;
}

function loadItem()
{
    if(currentRound >= maxRounds)
    {
        endGame();
        return;
    }

    currentItem = selectedItems[currentRound];
    guessedThisRound = false;

    document.getElementById("roundInfo").innerHTML =
        "Item " + (currentRound + 1) + " of 3";
    document.getElementById("itemName").innerHTML = currentItem.name;
    document.getElementById("itemImg").src = currentItem.image;
    document.getElementById("itemImg").alt = currentItem.name;
    document.getElementById("guess").value = "0.00";
}

function checkGuess()
{
    let guess;
    let difference;
    let moveTarget;

    if(gameOver || guessedThisRound)
    {
        return;
    }

    guess = parseFloat(document.getElementById("guess").value);
    if(isNaN(guess))
    {
        alert("Enter a number.");
        return;
    }

    difference = Math.abs(guess - currentItem.price);
    totalDifference = totalDifference + difference;
    guessedThisRound = true;

    if(totalDifference > scaleMax)
    {
        moveTarget = scaleMax;
    }
    else
    {
        moveTarget = totalDifference;
    }

    moveJoker(moveTarget);
    setButtons(true);

    document.getElementById("status").innerHTML =
        "Your guess is $" + guess.toFixed(2) +
        ". Real price: $" + currentItem.price.toFixed(2) +
        ". Difference: $" + difference.toFixed(2) +
        ". The Joker is moving to $" + moveTarget.toFixed(2) +
        " on the scale.";

    if(totalDifference > scaleMax)
    {
        setTimeout(endGame, 900);
    }
}

function nextItem()
{
    if(gameOver || !guessedThisRound)
    {
        return;
    }

    currentRound = currentRound + 1;
    setButtons(false);
    loadItem();
}

function endGame()
{
    gameOver = true;
    document.getElementById("go").disabled = true;
    document.getElementById("next").disabled = true;

    if(totalDifference <= scaleMax)
    {
        document.getElementById("status").innerHTML =
            "You win! Total difference: $" +
            totalDifference.toFixed(2) + ".";
        setJokerFace("smile");
        playSound("winSound");
    }
    else
    {
        document.getElementById("status").innerHTML =
            "Try again! Total difference: $" +
            totalDifference.toFixed(2) + ".";
        fallJoker();
    }
}

function moveJoker(amount)
{
    let joker = document.getElementById("joker");
    let target = (amount / scaleMax) * rulerWidth;

    if(amount >= scaleMax * 0.85)
    {
        setJokerFace("scared");
    }
    else
    {
        setJokerFace("walk");
    }

    joker.style.transition = "transform 0.8s linear";
    jokerX = target;
    jokerY = 0;
    jokerRotate = 0;
    updateJokerTransform();

    setTimeout(function ()
    {
        if(amount >= scaleMax)
        {
            setJokerFace("scared");
        }
        else
        {
            setJokerFace("smile");
        }
    }, 800);
}

function fallJoker()
{
    let joker = document.getElementById("joker");
    playSound("loseSound");
    setJokerFace("scared");
    joker.style.transition = "transform 0.8s linear";
    jokerY = 420;
    jokerRotate = 75;
    updateJokerTransform();

    setTimeout(function ()
    {
        joker.src = "img/clown3.png";
    }, 500);
}

function buildRuler()
{
    let ruler = document.getElementById("ruler");
    let markCount = Math.floor(scaleMax / 0.5);
    let i = 0;

    ruler.innerHTML = "";

    for(i = 0; i <= markCount; i++)
    {
        let mark = document.createElement("div");
        let label = document.createElement("span");
        let value = (i * 0.5).toFixed(2);

        mark.className = "mark";
        label.innerHTML = "$" + value;
        mark.appendChild(label);
        ruler.appendChild(mark);
    }
}

function resetJoker()
{
    let joker = document.getElementById("joker");

    joker.src = "img/clown1.png";
    joker.style.transition = "none";
    jokerX = 0;
    jokerY = 0;
    jokerRotate = 0;
    updateJokerTransform();
    setTimeout(function ()
    {
        joker.style.transition = "transform 0.8s linear";
    }, 0);
}

function setJokerFace(face)
{
    let joker = document.getElementById("joker");

    if(face === "walk")
    {
        joker.src = "img/clown.png";
    }
    else if(face === "scared")
    {
        joker.src = "img/clown2.png";
    }
    else
    {
        joker.src = "img/clown1.png";
    }
}

function setButtons(guessDone)
{
    if(guessDone)
    {
        document.getElementById("go").disabled = true;
        document.getElementById("next").disabled = false;
    }
    else
    {
        document.getElementById("go").disabled = false;
        document.getElementById("next").disabled = true;
    }
}

function playSound(soundId)
{
    let sound = document.getElementById(soundId);

    sound.currentTime = 0;
    sound.play();
}

function updateJokerTransform()
{
    let joker = document.getElementById("joker");

    joker.style.transform =
        "translateX(" + jokerX + "px) " +
        "translateY(" + jokerY + "px) " +
        "rotate(" + jokerRotate + "deg)";
}
