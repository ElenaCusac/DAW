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

  cambiarContenido(posicion) {
    let col = Array(6).fill("secondary");
    col[posicion] = this.state.colores[posicion];

    let nom = Array(6).fill("press");
    nom[posicion] = this.state.nombres[posicion];

    this.setState({ coloresActuales: col, nombresActuales: nom });
  }

  render() {
    return (
      <div className="App">
        <div>
          <Botoncico pos={0} color={this.state.coloresActuales[0]} nombre={this.state.nombresActuales[0]} cambiar={(p) => this.cambiarContenido(p)} />
          <Botoncico pos={1} color={this.state.coloresActuales[1]} nombre={this.state.nombresActuales[1]} cambiar={(p) => this.cambiarContenido(p)} />
          <Botoncico pos={2} color={this.state.coloresActuales[2]} nombre={this.state.nombresActuales[2]} cambiar={(p) => this.cambiarContenido(p)} />
          <Botoncico pos={3} color={this.state.coloresActuales[3]} nombre={this.state.nombresActuales[3]} cambiar={(p) => this.cambiarContenido(p)} />
          <Botoncico pos={4} color={this.state.coloresActuales[4]} nombre={this.state.nombresActuales[4]} cambiar={(p) => this.cambiarContenido(p)} />
          <Botoncico pos={5} color={this.state.coloresActuales[5]} nombre={this.state.nombresActuales[5]} cambiar={(p) => this.cambiarContenido(p)} />
        </div>
      </div>
    );
  }
}

function Botoncico(props) {
  return (
    <Button color={props.color} onClick={() => props.cambiar(props.pos)}> {props.nombre} </Button>
  );
}

export default App;