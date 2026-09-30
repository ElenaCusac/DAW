import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Button } from 'reactstrap';
import { Component } from 'react';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      matrizColores: Array(4).fill(null).map(() => Array(4).fill("secondary")),
    }
  }
  cambiaColor = (fila, columna) => {
    //Tengo que añadir tambien que cuando este en azul se ponga en el contenido un texto
    const copiaMatriz = JSON.parse(JSON.stringify(this.state.matrizColores));
    copiaMatriz[fila][columna] = copiaMatriz[fila][columna] === "secondary" ? "primary" : "secondary";
    this.setState({ matrizColores: copiaMatriz })
  }

  render() {
    const matriz4 = this.state.matrizColores.map((fila, i) => (
      <div>
        {fila.map((color, j) => (
          <Boton color={color} cambiaColor={() => this.cambiaColor(i, j)}
          />
        ))}
      </div>
    ));

    return (
      <div className="App">
        <h1>4 en raya</h1>
        {matriz4}
      </div>
    );
  }
}

const Boton = (props) => {
  return (
    <>
      <Button color={props.color} onClick={() => props.cambiaColor()}>{props.color==="primary"? "Ocupado": ""} </Button>
    </>
  );
}

export default App;