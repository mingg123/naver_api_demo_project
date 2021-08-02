import { combineReducers } from "redux";
import cartReducer from "./cartReducer";
const initialState = {
  value: "",
};

const store = combineReducers(cartReducer);
const reducerSearch = (state = initialState, action: any) => {
  switch (action.type) {
    default:
      return state;
  }
};

export default combineReducers({ cartReducer });
