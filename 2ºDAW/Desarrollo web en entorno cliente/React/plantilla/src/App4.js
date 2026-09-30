import 'bootstrap/dist/css/bootstrap.min.css';
import { Button } from 'reactstrap';
import { Component } from 'react';

class App extends Component {
    constructor(props) {
        super(props)
        this.state = {
            colores: ["primary", "secondary", "secondary"],
        };
    }

    cambiar(posicion) {
        let col = ["secondary", "secondary", "secondary"];
        col[posicion] = "primary";
        this.setState({colores: col});
    }

    render() {
        return (
            <div className="App">
                <Button color={this.state.colores[0]} onClick={() => this.cambiar(0)}><h1>Botón 1</h1></Button>
                <Button color={this.state.colores[1]} onClick={() => this.cambiar(1)}><h1>Botón 2</h1></Button>
                <Button color={this.state.colores[2]} onClick={() => this.cambiar(2)}><h1>Botón 3</h1></Button>
            </div>
        );
    }
}

export default App;