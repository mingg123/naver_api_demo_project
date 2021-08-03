import { Provider } from "react-redux";
import { createStore } from "redux";
import ItemsContainer from "./containers/ItemsContainer";
import rootReducer from "./modules";

const ItemMain = () => {
  const store = createStore(rootReducer);
  return (
    <div>
      <Provider store={store}>
        <ItemsContainer />
      </Provider>
    </div>
  );
};

export default ItemMain;
