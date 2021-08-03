const CHANGE_INPUT = "items/CHANGE_INPUT";

export const changeInput = (input: any) => ({
  type: CHANGE_INPUT,
  input,
});

const initialState = {
  input: "",
};

function items(state = initialState, action: any) {
  switch (action.type) {
    case CHANGE_INPUT:
      return {
        ...state,
        input: action.input,
      };
    default:
      return state;
  }
}

export default items;
