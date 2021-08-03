import { useDispatch, useSelector } from "react-redux";
import { RootState } from "../modules";
import { change, getData } from "../modules/shoppingsearch";
import ShoppingMainComponent from "../ShoppingMainComponent";
import ShoppingResultComponent from "../ShoppingResultComponent";

function ShoppingSearchContainer() {
  const search = useSelector((state: RootState) => state.shoppingsearch.value);
  const data = useSelector((state: RootState) => state.shoppingsearch.data);
  const dispatch = useDispatch();

  const onChangeInput = (diff: string) => {
    dispatch(change(diff));
  };

  const getDatas = (data: any) => {
    dispatch(getData(data));
  };
  return (
    <>
      <ShoppingMainComponent
        value={search}
        onChange={onChangeInput}
        getData={getDatas}
      />
      <ShoppingResultComponent data={data} />
    </>
  );
}

export default ShoppingSearchContainer;
