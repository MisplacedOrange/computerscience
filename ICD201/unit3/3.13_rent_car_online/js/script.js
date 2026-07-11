const cars = [
  { category: "economy", manufacturer: "honda", model: "Civic", year: "2016", seats: 5, doors: 4, price: 50 },
  { category: "economy", manufacturer: "hyundai", model: "Accent", year: "2016", seats: 5, doors: 4, price: 50 },
  { category: "economy", manufacturer: "nissan", model: "Sentra", year: "2019", seats: 5, doors: 4, price: 50 },

  { category: "sedan", manufacturer: "nissan", model: "Versa", year: "2025", seats: 5, doors: 4, price: 70 },
  { category: "sedan", manufacturer: "kia", model: "K5", year: "2025", seats: 5, doors: 4, price: 70 },
  { category: "sedan", manufacturer: "bmw", model: "7 series", year: "2025", seats: 5, doors: 4, price: 70 },

  { category: "suv", manufacturer: "toyota", model: "RAV4", year: "2025", seats: 5, doors: 4, price: 90 },
  { category: "suv", manufacturer: "hyundai", model: "Palisade", year: "2025", seats: 5, doors: 4, price: 90 },
  { category: "suv", manufacturer: "honda", model: "CR-V", year: "2025", seats: 5, doors: 4, price: 90 },

  { category: "luxury", manufacturer: "mercedes", model: "Mercedes-Benz", year: "2025", seats: 5, doors: 4, price: 120 },
  { category: "luxury", manufacturer: "bmw", model: "3 series", year: "2025", seats: 5, doors: 4, price: 120 },
  { category: "luxury", manufacturer: "porsche", model: "911", year: "2025", seats: 5, doors: 4, price: 120 }
];

let selectedCar = "";

function showModels() {
  let category = document.getElementById("category").value;
  let manufacturer = document.getElementById("manufacturer").value;
  let model = document.getElementById("model");

  model.innerHTML = '<option value="">-- Select Model --</option>';

  for (let i = 0; i < cars.length; i++) {
    if (cars[i].category == category && cars[i].manufacturer == manufacturer) {
      model.innerHTML += '<option value="' + cars[i].model + '">' + cars[i].model + '</option>';
    }
  }
}

function showYears() {
  let category = document.getElementById("category").value;
  let manufacturer = document.getElementById("manufacturer").value;
  let model = document.getElementById("model").value;
  let year = document.getElementById("year");

  year.innerHTML = '<option value="">-- Select Year --</option>';

  for (let i = 0; i < cars.length; i++) {
    if (
      cars[i].category == category &&
      cars[i].manufacturer == manufacturer &&
      cars[i].model == model
    ) {
      year.innerHTML += '<option value="' + cars[i].year + '">' + cars[i].year + '</option>';
    }
  }
}

function showCarDetails() {
  let category = document.getElementById("category").value;
  let manufacturer = document.getElementById("manufacturer").value;
  let model = document.getElementById("model").value;
  let year = document.getElementById("year").value;

  selectedCar = "";

  for (let i = 0; i < cars.length; i++) {
    if (
      cars[i].category == category &&
      cars[i].manufacturer == manufacturer &&
      cars[i].model == model &&
      cars[i].year == year
    ) {
      selectedCar = cars[i];
    }
  }

  if (selectedCar != "") {
    document.getElementById("numOfSeats").innerHTML = selectedCar.seats;
    document.getElementById("numOfDoors").innerHTML = selectedCar.doors;
    document.getElementById("price-per-day").innerHTML = selectedCar.price;
  }

  calculateSubtotal();
}

function calculateSubtotal() {
  if (selectedCar == "") {
    document.getElementById("subtotal").innerHTML = "0.00";
    document.getElementById("proceed").disabled = true;
    return;
  }

  let pickup = document.getElementById("pickup-date").value;
  let returnDate = document.getElementById("return-date").value;

  if (pickup == "" || returnDate == "") {
    document.getElementById("subtotal").innerHTML = "0.00";
    document.getElementById("proceed").disabled = true;
    return;
  }

  let start = new Date(pickup);
  let end = new Date(returnDate);

  let days = (end - start) / (1000 * 60 * 60 * 24);

  if (days <= 0) {
    document.getElementById("subtotal").innerHTML = "0.00";
    document.getElementById("proceed").disabled = true;
    return;
  }

  let total = selectedCar.price * days;

  if (document.getElementById("gps").checked) {
    total = total + 5 * days;
  }

  if (document.getElementById("child-seat").checked) {
    total = total + 7 * days;
  }

  if (document.getElementById("extra-driver").checked) {
  total = total + 10 * days;
}

  // Age surcharge: $10/day if driver under 25
  let ageInput = document.getElementById("driver-age");
  let age = ageInput ? parseInt(ageInput.value, 10) : NaN;
  if (!isNaN(age) && age < 25) {
    total = total + 10 * days;
  }

  total = total + Number(document.getElementById("insurance").value) * days;

  document.getElementById("subtotal").innerHTML = total.toFixed(2);

  if (total > 0) {
    document.getElementById("proceed").disabled = false;
  } else {
    document.getElementById("proceed").disabled = true;
  }
}

function removeBooking() {
  document.getElementById("category").value = "";
  document.getElementById("manufacturer").value = "";
  document.getElementById("model").innerHTML = '<option value="">-- Select Model --</option>';
  document.getElementById("year").innerHTML = '<option value="">-- Select Year --</option>';

  document.getElementById("pickup-date").value = "";
  document.getElementById("return-date").value = "";

  document.getElementById("gps").checked = false;
  document.getElementById("child-seat").checked = false;
  document.getElementById("insurance").value = "0";
  document.getElementById("extra-driver").checked = false;

  document.getElementById("numOfSeats").innerHTML = "--";
  document.getElementById("numOfDoors").innerHTML = "--";
  document.getElementById("price-per-day").innerHTML = "--";
  document.getElementById("subtotal").innerHTML = "0.00";

  selectedCar = "";
  document.getElementById("proceed").disabled = true;
}

function cancelBooking() {
  window.location.href = "index.html";
}

function proceedBooking() {
    window.location.href =
    "receipt.html?category=" + selectedCar.category +
    "&manufacturer=" + selectedCar.manufacturer +
    "&model=" + selectedCar.model +
    "&year=" + selectedCar.year +
    "&price=" + selectedCar.price +
    "&pickup=" + document.getElementById("pickup-date").value +
    "&return=" + document.getElementById("return-date").value +
    "&gps=" + document.getElementById("gps").checked +
    "&childSeat=" + document.getElementById("child-seat").checked +
    "&extraDriver=" + document.getElementById("extra-driver").checked +
    "&insurance=" + document.getElementById("insurance").value +
    "&subtotal=" + document.getElementById("subtotal").innerHTML +
    "&age=" + (document.getElementById("driver-age") ? document.getElementById("driver-age").value : "");
}

function initFromParams() {
  if (!document.getElementById('category')) return; // not on order page
  const params = new URLSearchParams(window.location.search);
  const cat = params.get('category');
  const manu = params.get('manufacturer');
  const model = params.get('model');
  const year = params.get('year');
  const price = params.get('price');
  const age = params.get('age');
  if (cat) document.getElementById('category').value = cat;
  if (manu) document.getElementById('manufacturer').value = manu;
  if (cat || manu) showModels();
  if (model) document.getElementById('model').value = model;
  if (model) showYears();
  if (year) document.getElementById('year').value = year;
  if (price && selectedCar === "") {
    // try to select matching car object
    for (let i=0;i<cars.length;i++){
      if (cars[i].category==cat && cars[i].manufacturer==manu && cars[i].model==model && cars[i].year==year) {
        selectedCar = cars[i];
        break;
      }
    }
  }
  if (age && document.getElementById('driver-age')) document.getElementById('driver-age').value = age;
  showCarDetails();
}

if (document.readyState === 'loading') document.addEventListener('DOMContentLoaded', initFromParams);
else initFromParams();

function getParams() {
	let params = new URLSearchParams(window.location.search);
		let car =  params.get("car-name");
		let daily_rate = params.get("daily_rate");
		let Rental_Days = params.get("rental_days");
	let category =  params.get("category") || "Economy" ;
	let manufacturer =  params.get("manufacturer") || "";
	let model = params.get("model") || "Vehicle" ;
	let year = params.get("year")|| "" ;
	let seats = params.get("seats");
	let door = params.get("door");
	let price_per_day = parseFloat(params.get("price")) || 50.00; //default
	let pickupStr = params.get("pickup") || params.get("pickup_date");
	let returnStr = params.get("return") || params.get("return-date");
	let pickup_date = new Date(pickupStr);
	let return_date = new Date (returnStr);
	let timeDifference = return_date.getTime() - pickup_date.getTime();
	let days = Math.round(timeDifference / (1000*60*60*24));
	let gps = params.get("gps");
	let childSeat = params.get("childSeat");
	let extraDriver = params.get("extraDriver");
    let subtotal = parseFloat(params.get("subtotal"));
    let age = parseInt(params.get("age"), 10);
	
	if (isNaN(days) || days <= 0) days = 0;

	return{
		category: category,
		manufacturer: params.get("manufacturer"),
		model: params.get("model"),
		year: params.get("year"),
		price_per_day: price_per_day,
		days: days,
		gps: params.get("gps") === "true",
		childSeat: params.get("childSeat") === "true",
		extraDriver: params.get("extraDriver") === "true",
    insurance_rate: parseFloat(params.get("insurance")) || 0,
    pickupStr: pickupStr,
    returnStr: returnStr,
    age: isNaN(age) ? null : age
	};

}
function displayReceipt(){
	let data = getParams();
	let baseCost = data.price_per_day * data.days;
	// disocunt rules
	let discountPercent = 0;
	if(data.days >=3 && data.days <=5) discountPercent = 0.05;
	else if(data.days >=6 && data.days <=10) discountPercent = 0.10;
	else if(data.days >=11) discountPercent = 0.15;
	let discountAmount = baseCost * discountPercent;
	let discountedCost = baseCost - discountAmount; 
	//Insurance 
	let insuranceName = "Basic Plan";
	if(data.insurance_rate === 15) insuranceName = "Standard Plan";
	if (data.insurance_rate === 30) insuranceName = "Premium Plan";
	let totalIC = data.insurance_rate * data.days;
	//add on
  let gpsCost = data.gps ? (5 * data.days): 0;
	let seatCost = data.childSeat ? (7* data.days): 0;
	let extraDriverCost = data.extraDriver ? (10 * data.days): 0;
  // age surcharge
  let ageSurcharge = 0;
  if (data.age && data.age < 25) {
    ageSurcharge = 10 * data.days;
  }
	//depositted amount
	let depositAmount = 200;
	if (data.category === "sedan") depositAmount = 300;
	else if(data.category ==="suv") depositAmount = 400;
	else if(data.category ==="luxury") depositAmount = 600;
	// summary
  let subtotal = discountedCost + totalIC + gpsCost + seatCost + extraDriverCost + ageSurcharge;
	let tax = subtotal * 0.13;
	let totalamount = subtotal + tax + depositAmount; 
	document.getElementById("car-name").innerHTML = data.manufacturer + "<br>" + data.model + "<br>" + data.year;
	document.getElementById("category").innerHTML = data.category;
	document.getElementById("daily_rate").innerHTML = data.price_per_day.toFixed(2);
	document.getElementById("rental_days").innerHTML =  data.days;
	document.getElementById("base_cost").innerHTML = baseCost.toFixed(2);
	document.getElementById("discount").innerHTML = discountAmount.toFixed(2);
	document.getElementById("total_cost").innerHTML = discountedCost.toFixed(2);
	document.getElementById("plan").innerHTML = insuranceName;
	document.getElementById("cost").innerHTML = totalIC.toFixed(2);
  document.getElementById("gps").innerHTML =  data.gps ? "$" + gpsCost.toFixed(2): "Not Selected";
  document.getElementById("age-surcharge").innerHTML = ageSurcharge > 0 ? "$" + ageSurcharge.toFixed(2) : "None";
  // booking & rental dates
  document.getElementById("booking-date").textContent = new Date().toLocaleDateString();
  document.getElementById("pickup-date-display").textContent = data.pickupStr ? new Date(data.pickupStr).toLocaleDateString() : "--";
  document.getElementById("return-date-display").textContent = data.returnStr ? new Date(data.returnStr).toLocaleDateString() : "--";
  // show saved amount
  document.getElementById("saved").textContent = discountAmount.toFixed(2);
	document.getElementById("childSeat").innerHTML = data.childSeat ? "$" + seatCost.toFixed(2): "Not Selected" ;
	document.getElementById("extraDriver").innerHTML = data.extraDriver ? "$" + extraDriverCost.toFixed(2): "Not Selected";
	document.getElementById("subtotal").innerHTML =  subtotal.toFixed(2);
	document.getElementById("tax").innerHTML = tax.toFixed(2);
	document.getElementById("deposit").innerHTML = depositAmount.toFixed(2);
	document.getElementById("total-amount").innerHTML = totalamount.toFixed(2);
}
