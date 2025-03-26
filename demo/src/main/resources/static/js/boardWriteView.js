/**
 * 
 */
document.addEventListener("DOMContentLoaded", function() {
	const inputs = document.querySelectorAll("input[required], textarea[required]");

	inputs.forEach(input => {

		input.addEventListener("blur", function() {

			const label = input.previousElementSibling.querySelector(".require");
			if (input.value.trim() === "") {
				label.style.color = "red";
			} else {
				label.style.color = "black";
			}

		});

		input.addEventListener("input", function() {
			const label = input.previousElementSibling.querySelector(".require");
			if (input.value.trim() !== "") {
				label.style.color = "black";
			}

		});




	});
});