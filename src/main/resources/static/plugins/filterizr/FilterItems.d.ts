import {Filter} from './ActiveFilter';
import FilterItem from './FilterItem';
import FilterizrOptions from './FilterizrOptions/FilterizrOptions';

export default class FilterItems {
    readonly length: number;
    private filterItems;
    private options;
    private shouldBeFiltered;

    constructor(filterItems: FilterItem[], options: FilterizrOptions);

    get(): FilterItem[];

    getItem(index: number): FilterItem;

    set(filterItems: FilterItem[]): void;

    destroy(): void;

    updateTransitionStyle(): void;

    updateDimensions(): void;

    push(filterItem: FilterItem): number;

    getFiltered(filter: Filter): FilterItem[];

    getFilteredOut(filter: Filter): FilterItem[];

    getSorted(sortAttr?: string, sortOrder?: 'asc' | 'desc'): FilterItem[];

    getSearched(searchTerm: string): FilterItem[];

    getShuffled(): FilterItem[];
}
