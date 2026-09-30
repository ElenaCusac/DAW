import Flashcard from "./FlashcardComponent";

const DisplayGodos = (props) => {
    const losreyes = props.reyes;
    const lista = losreyes.map((rey) =>
        <Flashcard  key={rey.id} imagen={rey.imagen} titulo={rey.nombre} texto={rey.texto}/>
    );

    return (
        <div>
            {lista}
        </div>
    );
}

export default DisplayGodos;