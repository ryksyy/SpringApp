//Properly displaying responses on the site itself seem like too much of a pain
//as html/js werent a part of the course I will only be implementing simple methods
//for each path
const url = "http://localhost:8080/"

function courseByID(){
    window.open(url + "searchCourseById?id=" + document.getElementById("courseByID").value)
}

function studentByID(){
    window.open(url + "searchStudentId?id=" + document.getElementById("studentByID").value)
}

function studentsByID(){
    window.open(url + "getStudentsOn?id=" + document.getElementById("studentsByID").value)
}

function studentCour(){
    window.open(url + "getStudentsCourses?id=" + document.getElementById("studentCour").value)
}

async function enroll(){
    let enrData = {
        studentId: document.getElementById("enrollStud").value,
        courseId: document.getElementById("enrollCour").value
    }
    postData('http://localhost:8080/enroll', enrData)
        .then((data) => {
            console.log(data)
        });
}

async function addStudent(){
    let data = {
        name: document.getElementById("newSn").value,
        age: document.getElementById("newSa").value,
        credits: document.getElementById("newSc").value
    }
    postData('http://localhost:8080/addStudent', data)
    .then((data) => {
        console.log(data)
    });
}

async function createOnline(){
    let data = {
        courseCred: document.getElementById("ocourseCred").value,
        courseName: document.getElementById("ocourseName").value,
        teacher: document.getElementById("oteacher").value,
        zoomLink: document.getElementById("zoom").value,
        recordingLink: document.getElementById("recordingLink").value
    }
    postData('http://localhost:8080/addOnlineCourse', data)
    .then((data) => {
        console.log(data)
    });
}

async function createRoom(){
    let data = {
        courseCred: document.getElementById("courseCred").value,
        courseName: document.getElementById("courseName").value,
        teacher: document.getElementById("teacher").value,
        classRoom: document.getElementById("room").value,
        weekDay: document.getElementById("day").value,
        startTime: document.getElementById("time").value,
        classLenght: document.getElementById("len").value
    }
    postData('http://localhost:8080/addClassCourse', data)
    .then((data) => {
        console.log(data)
    });
}

//General post data method from mozzila docs https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API/Using_Fetch
async function postData(url = '', data = {}) {
    // Default options are marked with *
    const response = await fetch(url, {
      method: 'POST', // *GET, POST, PUT, DELETE, etc.
      mode: 'same-origin', // no-cors, *cors, same-origin
      cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
      headers: {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin':'*'
        // 'Content-Type': 'application/x-www-form-urlencoded',
      },
      redirect: 'follow', // manual, *follow, error
      referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
      body: JSON.stringify(data) // body data type must match "Content-Type" header
    });
    return response.json(); // parses JSON response into native JavaScript objects
  }