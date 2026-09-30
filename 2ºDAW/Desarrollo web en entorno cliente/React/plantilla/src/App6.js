import React, { Component } from 'react';
import DisplayGodos from './componentes/DisplayGodos';
import { GODOS, NORMANDOS } from './shared/datos';
import { Button } from 'reactstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            reyes: GODOS,
            colores: ["primary", "secondary"]
        };
    }

    cambiarReyes = (posicion) => {
        if (posicion === 0) {
            this.setState({
                reyes: GODOS,
                colores: ["primary", "secondary"]
            });
        } else {
            this.setState({
                reyes: NORMANDOS,
                colores: ["secondary", "primary"]
            });
        }
    }

    render() {
        return (
            <div className="App">
                <header className="App-header">
                    <Button color={this.state.colores[0]} onClick={() => this.cambiarReyes(0)}> Godos </Button>
                    <Button color={this.state.colores[1]} onClick={() => this.cambiarReyes(1)}> Normandos </Button>
                    <DisplayGodos reyes={this.state.reyes} />
                </header>
            </div>
        );
    }
}

export default App;