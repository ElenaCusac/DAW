
import React, { Component } from 'react';
import { Button } from 'reactstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            colores: ["primary", "secondary", "success", "info", "warning", "danger"],
            nombres: ["azul", "gris", "verde", "azul", "amarillo", "rojo"],
            coloresActuales: Array(6).fill("secondary"),
            nombresActuales: Array(6).fill("press"),
        }
    }

    cambiarContenido(p) {
        let col = Array(6).fill("secondary");
        col[p] = this.state.colores[p];

        let nom = Array(6).fill("press");
        nom[p] = this.state.nombres[p];

        this.setState({ coloresActuales: col, nombresActuales: nom });
    }

    render() {
        return (
            <div className="App">
                <div>
                    {this.state.colores.map((color, p) =>
                        <Botoncico key={p} pos={p} color={this.state.coloresActuales[p]} nombre={this.state.nombresActuales[p]} cambiar={(p) => this.cambiarContenido(p)}/>
                    )}
                </div>
            </div>
        );
    }
}

function Botoncico(props) {
    return (
        <Button color={props.color} onClick={() => props.cambiar(props.pos)}>{props.nombre}</Button>
    );
}

export default App;
