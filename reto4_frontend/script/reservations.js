const tableBody = document.getElementById("tableBody");
const inputId = document.getElementById("inputId");
const inputStartDate = document.getElementById("inputStartDate");
const inputDevolutionDate = document.getElementById("inputDevolutionDate");
const selectClient = document.getElementById("selectClient");
const selectCar = document.getElementById("selectCar");
const inputStatus = document.getElementById("inputStatus");
const contenedorId = document.getElementById("contenedorId");
const btnModalFooter = document.getElementsByClassName("btn-modal-footer");

function obtener() {
  var requestOptions = {
    method: "GET",
    redirect: "follow",
  };

  fetch(`${GlobalHost}/api/Reservation/all`, requestOptions)
    .then((response) => response.json())
    .then((result) => {
      result.forEach((element) => {
        tableBody.innerHTML += `
                <tr>
                    <td>${element.startDate}</td>
                    <td>${element.devolutionDate}</td>
                    <td>${element.car.name}</td>
                    <td>${element.client.name}</td>
                    <td>${element.status}</td>
                    <td>
                    <button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#modal" onclick="btnDetails(${element.idReservation})">
                            Details
                        </button>
                    </td>
                </tr>
            `;
      });
    })
    .catch((error) => console.log("error", error));
}

function obtenerPorId(id) {
  var requestOptions = {
    method: "GET",
    redirect: "follow",
  };

  fetch(`${GlobalHost}/api/Reservation/${id}`, requestOptions)
    .then((response) => response.json())
    .then((result) => {
      inputId.value = result.idReservation;
      inputStartDate.value = result.startDate;
      inputDevolutionDate.value = result.devolutionDate;
      inputStatus.value = result.status;
      selectCar.innerHTML = `<option>${result.car.name}</option>`;
      selectClient.innerHTML = `<option>${result.client.name}</option>`;
    })
    .catch((error) => console.log("error", error));
}

function eliminar() {
  var requestOptions = {
    method: "DELETE",
    redirect: "follow",
  };

  fetch(`${GlobalHost}/api/Reservation/${inputId.value}`, requestOptions)
    .then((response) => window.location.reload())
    .catch((error) => console.log("error", error));
}

function actualizar() {
  var myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json");

  var raw = JSON.stringify({
    idReservation: inputId.value,
    startDate: inputStartDate.value,
    devolutionDate: inputDevolutionDate.value,
    status: inputStatus.value,
  });

  var requestOptions = {
    method: "PUT",
    headers: myHeaders,
    body: raw,
    redirect: "follow",
  };

  fetch(`${GlobalHost}/api/Reservation/update`, requestOptions)
    .then((response) => {
      window.location.reload();
    })
    .catch((error) => console.log("error", error));
}

function crear() {
  var myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json");

  var raw = JSON.stringify({
    startDate: inputStartDate.value,
    devolutionDate: inputDevolutionDate.value,
    client: {
      idClient: selectClient.value,
    },
    car: {
      idCar: selectCar.value,
    },
    status: inputStatus.value,
  });

  var requestOptions = {
    method: "POST",
    headers: myHeaders,
    body: raw,
    redirect: "follow",
  };

  fetch(`${GlobalHost}/api/Reservation/save`, requestOptions)
    .then((response) => {
      window.location.reload();
    })
    .catch((error) => console.log("error", error));
}

function obtenerCars() {
  selectCar.innerHTML = null;
  var requestOptions = {
    method: "GET",
    redirect: "follow",
  };

  fetch(`${GlobalHost}/api/Car/all`, requestOptions)
    .then((response) => response.json())
    .then((result) => {
      result.forEach((element) => {
        selectCar.innerHTML += `<option value="${element.idCar}">${element.name}</option>`;
      });
    })
    .catch((error) => console.log("error", error));
}

function obtenerClients() {
  selectClient.innerHTML = null;
  var requestOptions = {
    method: "GET",
    redirect: "follow",
  };

  fetch(`${GlobalHost}/api/Client/all`, requestOptions)
    .then((response) => response.json())
    .then((result) => {
      result.forEach((element) => {
        selectClient.innerHTML += `<option value="${element.idClient}">${element.name}</option>`;
      });
    })
    .catch((error) => console.log("error", error));
}

function limpiarInput() {
  const fecha = new Date();
  const m = fecha.getMonth() + 1;
  if (m > 10) {
    mm = `${m}`;
  } else {
    mm = "0" + `${m}`;
  }

  const dd = fecha.getDate();
  if (dd > 10) {
    ddd = `${dd}`;
  } else {
    ddd = "0" + `${dd}`;
  }

  inputId.value = null;
  inputStartDate.value =
    fecha.getFullYear() + "-" + mm + "-" + ddd + "T00:00:00.000+00:00";
  inputDevolutionDate.value =
    fecha.getFullYear() + "-" + mm + "-" + ddd + "T00:00:00.000+00:00";
  inputStatus.value = null;
}

function btnAdd() {
  btnModalFooter[0].style.display = "block";
  btnModalFooter[1].style.display = "none";
  btnModalFooter[2].style.display = "none";
  contenedorId.style.display = "none";
  selectCar.disabled = false;
  selectClient.disabled = false;
  limpiarInput();
  obtenerCars();
  obtenerClients();
}

function btnDetails(id) {
  btnModalFooter[0].style.display = "none";
  btnModalFooter[1].style.display = "block";
  btnModalFooter[2].style.display = "block";
  contenedorId.style.display = "block";
  selectCar.disabled = true;
  selectClient.disabled = true;
  obtenerPorId(id);
}

obtener();
