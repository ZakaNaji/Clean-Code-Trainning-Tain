import java.util.ArrayList;
import java.util.List;

public class Train {
    private List<Compartment> trainCompartments = new ArrayList<Compartment>() ;


    public Train(String compartmentsTypes){
        for (char compartmentsType : compartmentsTypes.toCharArray()){
            trainCompartments.add(findCompartmentToAdd(compartmentsType));
        }
    }

    private Compartment findCompartmentToAdd(char type) {
        switch (type){
            case 'H' : return new HeadCompartment();

            case 'P' : return new PassengerCompartment();

            case 'C' : return new EmptyCompartment();

            case 'R' : return new RestaurantCompartment();

            default: return null;
        }
    }

    public String print(){
        String trainShape = "";
        for(Compartment compartment : trainCompartments){
            trainShape += compartment.shape;
        }
        return trainShape;
    }

    public boolean compartmentIsEmpty(Compartment compartment){
        return (compartment.type == 'C');
    }

    public boolean fill(){
        for (int index = 0; index < trainCompartments.size(); index++){
            if(compartmentIsEmpty(trainCompartments.get(index))) {
                trainCompartments.set(index, new FullCompartment());
                return true;
            }
        }
        return false;
    }
}
