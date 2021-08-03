const CHANGE_INPUT = "shoppingsearch/CHANGE_INPUT" as const;
const GET_DATA = "shoppingsearch/GET_DATA" as const;

export const change = (diff: string) => ({
  type: CHANGE_INPUT,
  palyoad: diff,
});

export const getData = (data: any) => ({
  type: GET_DATA,
  palyoad: data,
});
type ShoppingSearchAction =
  | ReturnType<typeof change>
  | ReturnType<typeof getData>;

type ShoppingSearchState = {
  value: string;
  data: [];
};

const initialState: ShoppingSearchState = {
  value: "",
  data: [],
};

function shoppingsearch(
  state: ShoppingSearchState = initialState,
  action: ShoppingSearchAction
) {
  switch (action.type) {
    case CHANGE_INPUT:
      return {
        value: action.palyoad,
        data: state.data,
      };
    case GET_DATA:
      return {
        value: state.value,
        data: action.palyoad,
      };
    default:
      return state;
  }
}

export default shoppingsearch;
