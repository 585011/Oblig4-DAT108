"use strict";

const mobilValid = /^\d{8}$/;
const validFornavn = /^[A-ZÆØÅ]{1}[a-zA-ZæøåÆØÅ\\s-]{1,19}$/;
const validEtternavn = /^[A-ZÆØÅ]{1}[a-zA-ZæøåÆØÅ-]{1,19}$/;
const passLengdeValid = /^[a-zA-ZæøåÆØÅ0-9]{4,}$/;

function fornavnTest(){
	const fornavnRef = document.getElementByClassName("fornavn").value;
	fornavnRef.addEventListener('input', s => {
		if(!validFornavn.test(s)){
			alert("Må ha stor forbokstav og mellom 2 og 20 bokstaver")
			fornavnRef.classList.add("invalid")
		} else {
			fornavnRef.classList.remove("invalid")
			fornavnRef.classList.add("valid")
		}
	});
}

function etternavnTest(){
	const etternavnRef = document.getElementByClassName("etternavn").value;
	etternavnRef.addEventListener('input', s => {
		if(!validEtternavn.test(s)){
			alert("Må ha stor forbokstav, ingen mellomrom, og mellom 2-20 tegn")
			etternavnRef.classList.add("invalid")
		} else {
			etternavnRef.classList.remove("invalid")
			etternavnRef.classList.add("valid")
		}
	});
}

function mobilTest(){
	const mobilRef = document.getElementByClassName("mobil").value;
	mobilRef.addEventListener('input', s => {
		if(!mobilValid.test(s)){
			alert("Må ha nøyaktig 8 tall!")
			mobilRef.classList.add("invalid")
		} else {
			mobilRef.classList.remove("invalid")
			mobilRef.classList.add("valid")
		}
	});
}

function passordTest(){
	const passRef = document.getElementByClassName("passord").value;
	passRef.addEventListener('input', s => {
		if(!passLengdeValid(s)){
			alert("Passordet er for svakt")
			passRef.classList.add("invalid")
		} else {
			passRef.classList.remove("invalid")
			passRef.classList.remove("valid")
		}
	});
}

function likePassord(){
	const passRef = document.getElementByClassName("passord").value;
	const passRepRef = document.getElementByClassName("passordRepeter").value;
	passRepRef.addEventListener('input', s => {
		if(passRef === passRepRef){
			passRepRef.classList.add("valid")
		} else {
			alert("Passordene må være like")
			passRepRef.classList.add("invalid")
		}
	});
}