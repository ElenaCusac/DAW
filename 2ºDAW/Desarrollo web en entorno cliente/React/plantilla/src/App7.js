import 'bootstrap/dist/css/bootstrap.min.css';
import { Button } from 'reactstrap';
import { Component } from 'react';

class App extends Component {

    constructor(props) {
        super(props);

        this.state = {
            posiciones: [],
            colores: ["secondary", "secondary", "secondary", "secondary", "secondary"]
        };
    }

    cambiarColor(posicion) {

        let nuevasPosiciones = this.state.posiciones.slice();
        nuevasPosiciones.push(posicion);
        nuevasPosiciones = nuevasPosiciones.slice(-2);

        let nuevosColores = ["secondary", "secondary", "secondary", "secondary", "secondary"];

        for (let i = 0; i < nuevasPosiciones.length; i++) {
            nuevosColores[nuevasPosiciones[i]] = "primary";
        }

        this.setState({
            posiciones: nuevasPosiciones,
            colores: nuevosColores
        });
    }

    render() {
        return (
            <div className="App">
                <Button color={this.state.colores[0]} onClick={() => this.cambiarColor(0)}>Botón 1</Button>
                <Button color={this.state.colores[1]} onClick={() => this.cambiarColor(1)}>Botón 2</Button>
                <Button color={this.state.colores[2]} onClick={() => this.cambiarColor(2)}>Botón 3</Button>
                <Button color={this.state.colores[3]} onClick={() => this.cambiarColor(3)}>Botón 4</Button>
                <Button color={this.state.colores[4]} onClick={() => this.cambiarColor(4)}>Botón 5</Button>
            </div>
        );
    }
}

export default App;