export const SEARCH = "SEARCH";

export const addCart = (item: any) => {
  console.log(item);
  return {
    type: "ADD_ITEM",
    payload: item,
  };
};

export const deleteCart = (items: any) => {
  return {
    type: "DELETE_ITEM",
    payload: items,
  };
};
export const actionSearch = (value: string) => {
  return {
    type: SEARCH,
    payload: value,
  };
};
