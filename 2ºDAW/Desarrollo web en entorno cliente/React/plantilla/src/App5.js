import React, { Component } from 'react';
import Flashcard from './componentes/FlashcardComponent';
import { GODOS } from './shared/datos';

function DisplayGodos(props) {
    const losreyes = props.reyes;
    const lista = losreyes.map((rey) => <Flashcard key={rey.id} imagen={rey.imagen} titulo={rey.nombre} texto={rey.texto}/>);

    return (
        <div>
            {lista}
        </div>
    );
}

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            godos: GODOS,
        };
    }

    render() {
        return (
            <div className="App">
                <header className="App-header">
                    <DisplayGodos reyes={this.state.godos} />
                </header>
            </div>
        );
    }
}

export default App;