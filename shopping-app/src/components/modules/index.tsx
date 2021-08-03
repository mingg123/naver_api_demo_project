import { combineReducers } from "redux";
import shoppingsearch from "./shoppingsearch";

const rootReducer = combineReducers({
  shoppingsearch,
});

export default rootReducer;
export type RootState = ReturnType<typeof rootReducer>;
