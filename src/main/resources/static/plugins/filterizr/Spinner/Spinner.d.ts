import {Destructible, Styleable} from '../types/interfaces';
import FilterizrOptions from '../FilterizrOptions';
import FilterContainer from '../FilterContainer';
import StyledSpinner from './StyledSpinner';

export default class Spinner implements Destructible, Styleable {
    readonly styles: StyledSpinner;
    private node;
    private styledNode;
    private filterContainer;
    private initialize;

    constructor(filterContainer: FilterContainer, options: FilterizrOptions);

    destroy(): Promise<void>;
}
