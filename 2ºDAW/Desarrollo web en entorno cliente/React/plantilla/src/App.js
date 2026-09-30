//import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Component } from 'react';
import { Input, Button, Modal, ModalFooter, ModalHeader, ModalBody } from 'reactstrap';

const DIFICULTADES = [
    {
        id: 0,
        nombre: "Asistencia y puntualidad",
        descripcion: "Faltas de asistencia o puntualidad."
    },
    {
        id: 1,
        nombre: "Actitud",
        descripcion: "Falta de interés o motivación, pasividad en clase."
    },
    {
        id: 2,
        nombre: "Implicación",
        descripcion: "No trae el material necesario."
    },
    {
        id: 3,
        nombre: "Hábitos y técnicas de estudio",
        descripcion: "No realiza las tareas en casa, falta de organización, estudio insuficiente o inadecuado, dificultad para tomar apuntes o seguir explicaciones."
    },
    {
        id: 4,
        nombre: "Competencias básicas / instrumentales",
        descripcion: "Problemas de comprensión lectora, expresión escrita/oral, razonamiento lógico-matemático."
    },
    {
        id: 5,
        nombre: "Base previa",
        descripcion: "Base previa insuficiente en la materia."
    },
    {
        id: 6,
        nombre: "Atención",
        descripcion: "Habla demasiado, distracción frecuente."
    },
    {
        id: 7,
        nombre: "Ritmo",
        descripcion: "Ritmo lento de ejecución, dificultad para seguir instrucciones."
    },
    {
        id: 8,
        nombre: "Seguimiento de procedimientos",
        descripcion: "Dificultad para seguir guiones de prácticas o protocolos técnicos paso a paso sin saltarse fases."
    },
    {
        id: 9,
        nombre: "Resolución de problemas (Troubleshooting)",
        descripcion: "Bloqueo ante fallos imprevistos; no aplica un método lógico de descarte y busca directamente la solución del docente o en la IA."
    }
];


const Formulario = (props) => {
    return (<>
        <div>
            <Modal isOpen={props.mostrar} toggle={props.toggleModal} >
                <ModalHeader toggle={props.toggleModal}>ALUMNOS Y ASIGNATURAS</ModalHeader>
                <form>
                    <ModalBody>
                        <h3>ALUMNOS:</h3>
                        <Input type="textarea" name="alumnos" placeholder='["alumno1", "alumno2", "alumno3"]' required />

                        <h3>ASIGNATURAS:</h3>
                        <Input type="textarea" name="alumnos" placeholder='["asignatura1", "asignatura2"]' required />
                    </ModalBody>
                    <ModalFooter>
                        <Button color="primary" type="submit">
                            GENERAR CUESTIONARIOS
                        </Button>
                    </ModalFooter>
                </form>
            </Modal>
        </div>
    </>)
}


const Cuestionario = (props) => {
    return (<>
        <h1>CUESTIONARIO</h1>

    </>)
}
const Alumno = (props) => {
    return (<></>)

}
const Asignatura = () => {
    return (<></>)

}

class App extends Component {
    constructor(props) {
        super(props)
        this.state = {
            displayFormulario: true,
            informe: false,
            alumnos: undefined,
            asignaturas: undefined,
            cuestionario: [],
        }
    }

    toggleModal() {
        this.setState({ displayFormulario: !this.state.displayFormulario })
    };

    setFormulario(alu, asig) {
        this.setState({ alumnos: alu, asignaturas: asig, displayFormulario: !this.state.displayFormulario })
    }

    render() {
        let mostrarComponentes = this.state.displayFormulario ?
            <Formulario mostrar={this.state.displayFormulario} toggleModal={() => this.toggleModal()} /> :
            <Cuestionario />
        return (
            <div className="App">
                {mostrarComponentes}
            </div>
        );
    }
}

export default App;