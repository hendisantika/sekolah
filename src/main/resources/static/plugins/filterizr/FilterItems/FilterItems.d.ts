import StyledFilterItems from './StyledFilterItems';
import {Filter} from '../types';
import FilterItem from '../FilterItem';
import FilterizrOptions from '../FilterizrOptions/FilterizrOptions';
import {Destructible, Styleable} from '../types/interfaces';

export default class FilterItems implements Destructible, Styleable {
    readonly styles: StyledFilterItems;
    readonly length: number;
    private filterItems;
    private styledFilterItems;
    private options;
    private search;
    private shouldBeFiltered;

    constructor(filterItems: FilterItem[], options: FilterizrOptions);

    getItem(index: number): FilterItem;

    destroy(): void;

    push(filterItem: FilterItem): number;

    remove(node: HTMLElement): void;

    getFiltered(filter: Filter): FilterItem[];

    getFilteredOut(filter: Filter): FilterItem[];

    sort(sortAttr?: string, sortOrder?: 'asc' | 'desc'): void;

    shuffle(): void;
}
