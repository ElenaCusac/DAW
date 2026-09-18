let minutos = 0;
let segundos = 0;
let cronometro;

function iniciar() {

    cronometro = setInterval(function() {

        segundos++;

        if (segundos == 60) {
            segundos = 0;
            minutos++;
        }

        document.getElementById("cronometro").textContent =
            String(minutos).padStart(2, "0") + ":" +
            String(segundos).padStart(2, "0");

    }, 1000);
}

function parar() {
    clearInterval(cronometro);
}

function reiniciar() {

    clearInterval(cronometro);

    minutos = 0;
    segundos = 0;

    document.getElementById("cronometro").textContent = "00:00";
}